package com.cafe.coffee.dto;

import com.cafe.coffee.entity.Coffee;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class CoffeeDto {
    @Getter
    public static class Post {
        @NotBlank
        @Pattern(regexp = "^([가-힣ㄱ-ㅎㅏ-ㅣ])(\\s?[가-힣ㄱ-ㅎㅏ-ㅣ])*$",
                message = "커피명(한글)은 한글(자음 모음만 가능)만 허용합니다.\n" + "단어 사이에 한칸의 공백(스페이스)만 포함 될 수 있습니다.\n")
        private String korName;

        @NotBlank
        @Pattern(regexp = "^([A-Za-z])(\\s?[A-Za-z])*$",
                message = "커피명(영문)은 영문(대소문자 모두 가능)만 허용합니다.\n" + "단어 사이에 한칸의 공백(스페이스)만 포함 될 수 있습니다.\n")
        private String engName;

        @Range(min = 0, max = 500000)
        private Integer price;

        @NotBlank
        @Pattern(regexp = "^([A-Za-z]){3}$",
                message = "커피 코드는 3자리의 영문이어야 합니다.")
        private String coffeeCode;
    }

    @Getter
    public static class Patch {
        private long coffeeId;

        @Pattern(regexp = "^([가-힣ㄱ-ㅎㅏ-ㅣ])(\\s?[가-힣ㄱ-ㅎㅏ-ㅣ])*$",
                message = "커피명(한글)은 한글(자음 모음만 가능)만 허용합니다.\n" + "단어 사이에 한칸의 공백(스페이스)만 포함 될 수 있습니다.\n")
        private String korName;

        @Pattern(regexp = "^([A-Za-z])(\\s?[A-Za-z])*$",
                message = "커피명(영문)은 영문(대소문자 모두 가능)만 허용합니다.\n" + "단어 사이에 한칸의 공백(스페이스)만 포함 될 수 있습니다.\n")
        private String engName;

        @Range(min = 0, max = 50000)
        private Integer price;

        private Coffee.CoffeeStatus coffeeStatus;

        public void setCoffeeId(long coffeeId) {
            this.coffeeId = coffeeId;
        }
    }

    @Getter
    @AllArgsConstructor
    public static class Response {
        private long coffeeId;
        private String korName;
        private String engName;
        private Integer price;
        private String coffeeCode;
    }

}