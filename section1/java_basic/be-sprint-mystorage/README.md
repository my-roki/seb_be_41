# be-sprint-mystorage

# **์ค์ต - ๊ฐ์**

๐ก **`ํธ์์  ๋ฐ์ฃผ ํ๋ก๊ทธ๋จ ๋ง๋ค๊ธฐ`**

๋ณธ `์์ `๋ **ํธ์์ **, **์์์ **, **์นดํ** ๋ฑ `์ ์ฅ ๊ณต๊ฐ`์ ๊ฐ์ง๊ณ  ์๋ ๊ณณ ์ด๋ผ๋ฉด **์์ ๋กญ๊ฒ ์ฌ์ฉ**ํ  ์ ์๋ `**๋ฐ์ฃผ ํ๋ก๊ทธ๋จ**`์ ์ ์ํ์ฌ ๋ด๋๋ค.
**ํด๋น ํ๋ก๊ทธ๋จ**์ ๋ฌผ๊ฑด์ **`๋ฑ๋ก`**ํ๊ฑฐ๋ **`๋นผ๋`** ๋ฑ์ ๊ธฐ๋ณธ์ ์ธ ๊ธฐ๋ฅ๋ง์ ๊ฐ๋๋ก ํฉ๋๋ค.

(**โป** ๋ฐ๋์ **`๊ฐ์ฒด ์งํฅ`**์ ์์์ผ๋ง **`JAVA`** ๋ก ํ๋ก๊ทธ๋จ์ ์งค ์ ์๋ ๊ฒ์ ์๋๋๋ค. ๊ธฐ๋ณธ ํ์, ์ ์ด๋ฌธ, ํจ์, String ์ ํ์ฉํด ์์ ํ๋ก๊ทธ๋จ์ ๋ง๋ค ์ ์์ต๋๋ค. )

# **๐ฅ [ํธ์์  ๋ฐ์ฃผ ํ๋ก๊ทธ๋จ] ์ถ๋ ฅ ์์**

โ ๋ณธ ํ๋ก๊ทธ๋จ์ `๋ช๋ น ํ๋กฌํํธ(CMD)`์ ์ด์ด ์คํํ  ์ ์๋๋ก ํฉ๋๋ค.

`.java ํ์ผ`์ ์คํํ๊ธฐ ์ํด์๋ `java` ๋ช๋ น์ด๋ฅผ ์์ฑํ๊ณ  ๊ทธ ๋ค์ ํ์ผ ๋ช(`MyStorageV3.java`) ์ ์๋ ฅํ์ฌ ์ค๋๋ค.

(**โป** `main(String[] args`) ๋ฉ์๋์ `String[] args` ์ธ์์ ๊ฐ์ ํ ๋นํ๊ธฐ ์ํด ํ์ผ๋ช ๋ค์ ๊ฐ(`โ์ฝ๋์คํ์ด์ธ โ`)์ ์๋ ฅํ์ฌ ์ฃผ์์ต๋๋ค.)

```
โฏ java MyStorageV3.java "์ฝ๋์คํ์ด์ธ "
```

```
[Item_Storage_V3]
------------------------------
[System] ์ฝ๋์คํ์ด์ธ  ์ ์ฅ๋ ์ด์์ค์ธ์.
[System] ํด๋น ํ๋ก๊ทธ๋จ์ ๊ธฐ๋ฅ์๋๋ค.
1. ๋ฌผ๊ฑด ์ ๋ณด(์ ํ๋ช) ๋ฑ๋กํ๊ธฐ
2. ๋ฌผ๊ฑด ์ ๋ณด(์ ํ๋ช) ๋ฑ๋ก ์ทจ์ํ๊ธฐ
3. ๋ฌผ๊ฑด ๋ฃ๊ธฐ (์ ํ ์๊ณ )
4. ๋ฌผ๊ฑด ๋นผ๊ธฐ (์ ํ ์ถ๊ณ )
5. ์ฌ๊ณ  ์กฐํ
6. ํ๋ก๊ทธ๋จ ์ข๋ฃ
------------------------------
[System] ์ํ๋ ๊ธฐ๋ฅ์ ๋ฒํธ๋ฅผ ์๋ ฅํ์ธ์ : 1
[System] ์ ํ ๋ฑ๋ก์ ์ํ๋ ์ ํ๋ช์ ์๋ ฅํ์ธ์ : ์ฌ์ด๋ค
[System]๋ฑ๋ก์ด ์๋ฃ๋ฌ์ต๋๋ค.
[System] ํ์ฌ ๋ฑ๋ก๋ ์ ํ ๋ชฉ๋ก โผ
> ์ฌ์ด๋ค
> ๋ฑ๋ก ๊ฐ๋ฅ
> ๋ฑ๋ก ๊ฐ๋ฅ
> ๋ฑ๋ก ๊ฐ๋ฅ
> ๋ฑ๋ก ๊ฐ๋ฅ
------------------------------
1. ๋ฌผ๊ฑด ์ ๋ณด(์ ํ๋ช) ๋ฑ๋กํ๊ธฐ
2. ๋ฌผ๊ฑด ์ ๋ณด(์ ํ๋ช) ๋ฑ๋ก ์ทจ์ํ๊ธฐ
3. ๋ฌผ๊ฑด ๋ฃ๊ธฐ (์ ํ ์๊ณ )
4. ๋ฌผ๊ฑด ๋นผ๊ธฐ (์ ํ ์ถ๊ณ )
5. ์ฌ๊ณ  ์กฐํ
6. ํ๋ก๊ทธ๋จ ์ข๋ฃ
------------------------------
[System] ์ํ๋ ๊ธฐ๋ฅ์ ๋ฒํธ๋ฅผ ์๋ ฅํ์ธ์ : 3
[System] ๋ฌผ๊ฑด์ ์๋์ ์ถ๊ฐํฉ๋๋ค.(์๊ณ )
[System] ํ์ฌ ๋ฑ๋ก๋ ์ ํ ๋ฐ ์๋ โผ
> ์ฌ์ด๋ค : 0๊ฐ
> ๋ฑ๋ก ๊ฐ๋ฅ : 0๊ฐ
> ๋ฑ๋ก ๊ฐ๋ฅ : 0๊ฐ
> ๋ฑ๋ก ๊ฐ๋ฅ : 0๊ฐ
> ๋ฑ๋ก ๊ฐ๋ฅ : 0๊ฐ
[System] ์๋์ ์ถ๊ฐํ  ์ ํ๋ช์ ์๋ ฅํ์ธ์ : ์ฌ์ด๋ค
[System] ์ถ๊ฐํ  ์๋์ ์๋ ฅํด์ฃผ์ธ์ : 100
[Clear] ์ ์์ ์ผ๋ก ์ ํ์ ์๋ ์ถ๊ฐ๊ฐ ์๋ฃ๋์์ต๋๋ค.
[System] ํ์ฌ ๋ฑ๋ก๋ ์ ํ ๋ฐ ์๋ โผ
> ์ฌ์ด๋ค : 100๊ฐ
> ๋ฑ๋ก ๊ฐ๋ฅ : 0๊ฐ
> ๋ฑ๋ก ๊ฐ๋ฅ : 0๊ฐ
> ๋ฑ๋ก ๊ฐ๋ฅ : 0๊ฐ
> ๋ฑ๋ก ๊ฐ๋ฅ : 0๊ฐ
------------------------------
1. ๋ฌผ๊ฑด ์ ๋ณด(์ ํ๋ช) ๋ฑ๋กํ๊ธฐ
2. ๋ฌผ๊ฑด ์ ๋ณด(์ ํ๋ช) ๋ฑ๋ก ์ทจ์ํ๊ธฐ
3. ๋ฌผ๊ฑด ๋ฃ๊ธฐ (์ ํ ์๊ณ )
4. ๋ฌผ๊ฑด ๋นผ๊ธฐ (์ ํ ์ถ๊ณ )
5. ์ฌ๊ณ  ์กฐํ
6. ํ๋ก๊ทธ๋จ ์ข๋ฃ
------------------------------
[System] ์ํ๋ ๊ธฐ๋ฅ์ ๋ฒํธ๋ฅผ ์๋ ฅํ์ธ์ : 4
[System] ์ ํ์ ์ถ๊ณ ๋ฅผ ์งํํฉ๋๋ค.
[System] ํ์ฌ ๋ฑ๋ก๋ ๋ฌผ๊ฑด ๋ชฉ๋ก ๋ฐ ์๋ โผ
> ์ฌ์ด๋ค : 100๊ฐ
> ๋ฑ๋ก ๊ฐ๋ฅ : 0๊ฐ
> ๋ฑ๋ก ๊ฐ๋ฅ : 0๊ฐ
> ๋ฑ๋ก ๊ฐ๋ฅ : 0๊ฐ
> ๋ฑ๋ก ๊ฐ๋ฅ : 0๊ฐ
[System] ์ถ๊ณ ๋ฅผ ์งํํ  ์ ํ๋ช์ ์๋ ฅํ์ธ์ : ์ฌ์ด๋ค
[System] ์ํ๋ ์ถ๊ณ ๋์ ์๋ ฅํ์ธ์ : 100
[Clear] ์ถ๊ณ ๊ฐ ์๋ฃ๋์์ต๋๋ค.
[System] ํ์ฌ ๋ฑ๋ก๋ ์ ํ ๋ฐ ์๋ โผ
> ์ฌ์ด๋ค : 0๊ฐ
> ๋ฑ๋ก ๊ฐ๋ฅ : 0๊ฐ
> ๋ฑ๋ก ๊ฐ๋ฅ : 0๊ฐ
> ๋ฑ๋ก ๊ฐ๋ฅ : 0๊ฐ
> ๋ฑ๋ก ๊ฐ๋ฅ : 0๊ฐ
1. ๋ฌผ๊ฑด ์ ๋ณด(์ ํ๋ช) ๋ฑ๋กํ๊ธฐ
2. ๋ฌผ๊ฑด ์ ๋ณด(์ ํ๋ช) ๋ฑ๋ก ์ทจ์ํ๊ธฐ
3. ๋ฌผ๊ฑด ๋ฃ๊ธฐ (์ ํ ์๊ณ )
4. ๋ฌผ๊ฑด ๋นผ๊ธฐ (์ ํ ์ถ๊ณ )
5. ์ฌ๊ณ  ์กฐํ
6. ํ๋ก๊ทธ๋จ ์ข๋ฃ
------------------------------
[System] ์ํ๋ ๊ธฐ๋ฅ์ ๋ฒํธ๋ฅผ ์๋ ฅํ์ธ์ : 2
[System] ์ ํ ๋ฑ๋ก ์ทจ์๋ฅผ ์ํ๋ ์ ํ๋ช์ ์๋ ฅํ์ธ์ : ์ฌ์ด๋ค
[System] ์ ํ ์ทจ์๊ฐ ์๋ฃ๋ฌ์ต๋๋ค.
1. ๋ฌผ๊ฑด ์ ๋ณด(์ ํ๋ช) ๋ฑ๋กํ๊ธฐ
2. ๋ฌผ๊ฑด ์ ๋ณด(์ ํ๋ช) ๋ฑ๋ก ์ทจ์ํ๊ธฐ
3. ๋ฌผ๊ฑด ๋ฃ๊ธฐ (์ ํ ์๊ณ )
4. ๋ฌผ๊ฑด ๋นผ๊ธฐ (์ ํ ์ถ๊ณ )
5. ์ฌ๊ณ  ์กฐํ
6. ํ๋ก๊ทธ๋จ ์ข๋ฃ
------------------------------
[System] ์ํ๋ ๊ธฐ๋ฅ์ ๋ฒํธ๋ฅผ ์๋ ฅํ์ธ์ : 5
[System] ํ์ฌ ๋ฑ๋ก๋ ๋ฌผ๊ฑด ๋ชฉ๋ก โผ
> ๋ฑ๋ก ๊ฐ๋ฅ : 0๊ฐ
> ๋ฑ๋ก ๊ฐ๋ฅ : 0๊ฐ
> ๋ฑ๋ก ๊ฐ๋ฅ : 0๊ฐ
> ๋ฑ๋ก ๊ฐ๋ฅ : 0๊ฐ
> ๋ฑ๋ก ๊ฐ๋ฅ : 0๊ฐ
1. ๋ฌผ๊ฑด ์ ๋ณด(์ ํ๋ช) ๋ฑ๋กํ๊ธฐ
2. ๋ฌผ๊ฑด ์ ๋ณด(์ ํ๋ช) ๋ฑ๋ก ์ทจ์ํ๊ธฐ
3. ๋ฌผ๊ฑด ๋ฃ๊ธฐ (์ ํ ์๊ณ )
4. ๋ฌผ๊ฑด ๋นผ๊ธฐ (์ ํ ์ถ๊ณ )
5. ์ฌ๊ณ  ์กฐํ
6. ํ๋ก๊ทธ๋จ ์ข๋ฃ
------------------------------
[System] ์ํ๋ ๊ธฐ๋ฅ์ ๋ฒํธ๋ฅผ ์๋ ฅํ์ธ์ : 6
[System] ํ๋ก๊ทธ๋จ์ ์ข๋ฃํฉ๋๋ค.
[System] ๊ฐ์ฌํฉ๋๋ค.
```

# **๐กย [CuGs7 ์ ์ฅ๋]์ด ๋ณด๋ด์จ ํ๋ก๊ทธ๋๋ฐ ์์ฒญ์**

---

โ๏ธ \*\*[ํธ์์ ์์ ํ์ฉํ  ์ ์๋ ํ๋ก๊ทธ๋จ ๊ธฐ๋ฅ]

๋ณธ ํ๋ก๊ทธ๋จ์ ์๋์ ๊ฐ์ด `์ฌ์ฏ๊ฐ์ง ๊ธฐ๋ฅ`์ ์ถ๊ฐํด ์ฃผ์ธ์.\*\*

1. ๋ฌผ๊ฑด ์ ๋ณด(์ ํ๋ช) ๋ฑ๋กํ๊ธฐ
2. ๋ฌผ๊ฑด ์ ๋ณด(์ ํ๋ช) ๋ฑ๋ก ์ทจ์ํ๊ธฐ
3. ๋ฌผ๊ฑด ๋ฃ๊ธฐ (์ ํ ์๊ณ )
4. ๋ฌผ๊ฑด ๋นผ๊ธฐ (์ ํ ์ถ๊ณ )
5. ์ฌ๊ณ  ์กฐํ
6. ํ๋ก๊ทธ๋จ ์ข๋ฃ

   (**โป** **`ํ๋ก๊ทธ๋จ ์ข๋ฃ`** ๊ธฐ๋ฅ์ ์คํํ์ง ์๋ ํ ๊ณ์ํด์ ํ๋ก๊ทธ๋จ์ด ๋์๊ฐ ์ ์๋๋ก ํฉ๋๋ค.)

# **๐ ย [์ฝ๋์คํ์ด์ธ ]์์ ๋ด๋ ค์จ ํ๋ก๊ทธ๋๋ฐ ์ฐธ๊ณ ์ฌํญ**

โ **์ ๋ด์ฉ์ ์ด๋ป๊ฒ ์ฝ๋ฉํ  ์ ์์๊น์?**

**ํ๋ก๊ทธ๋จ์ ์ฝ๋ฉ**ํ  ๋ ๋ง๋ค ์ ์ฐจ `๋ ๋ง์ ๊ธฐ๋ฅ`๋ค์ **์์ฒญ**๋ฐ๊ฒ ๋ฉ๋๋ค. ๋ค์ํ ๊ธฐ๋ฅ๋ค์ ์ฝ๋๋ก ์ ์ํ๊ธฐ ์ , **`ํ๋ก๊ทธ๋จ์ ์์๋`** ํน์ **`๊ธฐ๋ฅ์ ๋ฐ๋ฅธ ๋ฉ์๋`** ๋ฅผ `๊ทธ๋ฆผ`์ผ๋ก ๋จผ์  ๊ทธ๋ ค๋ด๋๋ค. ๊ทธ๋ฆฌ๊ณ  ์ด๋ฅผ ๋ฐํ์ผ๋ก `์ฝ๋`๋ฅผ ์์ฑํ์ฌ ๋ด๋๋ค.

โผ **[ 1 ๋จ๊ณ ] ํ๋ก๊ทธ๋จ์ ํ์ํ `๊ธฐ๋ฅ`๋ค ์๊ฐํด ๋ณด๊ธฐ**

<img src="https://s3.ap-northeast-2.amazonaws.com/urclass-images/0ge3jLW6iVSa1S_iayOgA-1652318660884.png" />

**โผ** [ 2 ๋จ๊ณ ] ํ๋ก๊ทธ๋จ์ ํ์ํ ๊ธฐ๋ฅ๋ค `๋ฉ์๋๋ก ์ ์`ํด ๋ณด๊ธฐ\*\*

<img src="https://s3.ap-northeast-2.amazonaws.com/urclass-images/CRK3FGbvq24qA9iyaFS5I-1652318684200.png" />

โผ **[ 3 ๋จ๊ณ ] ํ๋ก๊ทธ๋จ ๋ฉ์๋๋ค์ `ํ๋ฆ๋`๋ฅผ ๊ทธ๋ ค๋ณด๊ธฐ**

<img src="https://s3.ap-northeast-2.amazonaws.com/urclass-images/KPikzjBAZlPvWcga1U2-g-1652318702626.png" />

โ๏ธ **๋ฉ์๋ ์ฆ๊ฐ**
๋ฉ์๋๋ฅผ ๋ง๋ค๊ธฐ ์ํด์๋ **๋ฉ์๋์ `์๋ ฅ`**๊ณผ **`์ถ๋ ฅ`**์ ์ด๋ป๊ฒ ์ ํ  ๊ฒ์ธ๊ฐ๊ฐ ์ค์ํฉ๋๋ค.

์ด๋ฒ ํ๋ก๊ทธ๋จ์ `**๋จ๊ณ์ ์ผ๋ก ๋ฒ์ ์ ์๋ฐ์ดํธ ํ๋ ๋ฐฉ์**`์ ์ทจํด์ฃผ์ธ์.

**์ฒซ ๋ฒ์งธ ๋ฒ์ **์ **๋ฉ์ธ ๋ฉ์๋`main(String[] args)`์ ์ผ๋ถ ๋ฉ์๋**๋ฅผ **์ ์**ํ์ฌ ์ฃผ์ธ์.

**๋ ๋ฒ์งธ ๋ฒ์ **์ **`์ผ๋ถ๋ฅผ ์ ์๋ ๋ฉ์๋`** ๋ฅผ ํตํด **ํ๋ก๊ทธ๋จ์ด ์ ์์ ์ผ๋ก ๋์**ํ๋์ง ํ์ธํ์ฌ ์ฃผ์ธ์.

**์ธ ๋ฒ์งธ ๋ฒ์ **์ **`๋ฉ์๋์ ๋ชจ๋  ๊ธฐ๋ฅ์ ์ ์`ํ๊ณ  ๋ชจ๋  ๊ธฐ๋ฅ๋ค์ด ์ ์์ ์ผ๋ก ๋์**ํ๋์ง ํ์ธํ์ฌ ์ฃผ์์.
