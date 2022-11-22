package com.cafe.coffee.service;

import com.cafe.coffee.entity.Coffee;
import com.cafe.coffee.repository.CoffeeRepository;
import com.cafe.exception.BusinessLogicException;
import com.cafe.exception.ExceptionCode;
import com.cafe.utils.CustomBeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@Service
public class CoffeeService {
    private CoffeeRepository coffeeRepository;
    private StorageService storageService;
    private CustomBeanUtils beanUtils;

    public CoffeeService(CoffeeRepository coffeeRepository, StorageService storageService, CustomBeanUtils beanUtils) {
        this.coffeeRepository = coffeeRepository;
        this.storageService = storageService;
        this.beanUtils = beanUtils;
    }

    public Coffee createCoffee(Coffee coffee, MultipartFile coffeeImage) {
        String coffeeCode = coffee.getCoffeeCode().toUpperCase();

        // 커피 객체에 이미지 정보 추가
        coffee.setCoffeeImageName(coffeeImage.getOriginalFilename());

        verifyCoffeeExistCode(coffeeCode);
        coffee.setCoffeeCode(coffeeCode);
        storageService.store(coffeeImage);

        return coffeeRepository.save(coffee);
    }

    public Page<Coffee> findCoffees(int page, int size) {
        return coffeeRepository.findAll(PageRequest.of(page, size,
                Sort.by("coffeeId")));
    }

    public Coffee findCoffee(long coffeeId) {
        return isCoffeeExist(coffeeId);
    }

    public List<Coffee> findOrderedCoffees(List<Long> coffeeIdList) {
        List<Coffee> coffees = (List<Coffee>) coffeeRepository.findAllById(coffeeIdList);
        return coffees;
    }

    public Coffee updateCoffee(Coffee coffee) {
        Coffee isCoffee = isCoffeeExist(coffee.getCoffeeId());
        beanUtils.copyNonNullProperties(coffee, isCoffee);

        return coffeeRepository.save(isCoffee);
    }

    public void deleteCoffee(long coffeeId) {
        Coffee isCoffee = isCoffeeExist(coffeeId);
        coffeeRepository.delete(isCoffee);
    }

    private void verifyCoffeeExistCode(String coffeeCode) {
        Optional<Coffee> optionalCoffee = coffeeRepository.findByCoffeeCode(coffeeCode);
        if (optionalCoffee.isPresent()) throw new BusinessLogicException(ExceptionCode.COFFEE_CODE_EXISTS);
    }

    public Coffee isCoffeeExist(long coffeeId) {
        Optional<Coffee> coffee = coffeeRepository.findById(coffeeId);
        return coffee.orElseThrow(() -> new BusinessLogicException(ExceptionCode.COFFEE_NOT_FOUND));
    }
}