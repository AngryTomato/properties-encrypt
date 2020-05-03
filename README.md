# properties-encrypt
encrypt application.properties in springboot

该工具是为了更加方便的加密SpringBoot中的配置文件。



## 使用指南

1.项目启动前，需要在`application.properties`中配置：

```
jasypt.encryptor.password=
```



2.在上方文本框中填写待加密的字符串（例如：mysql的用户名**root**），然后点击加密，下方文本框即可获得加密过后的Base64字符串。

3.在下方文本框中填写已加密的Base64字符串，然后点击解密，上方文本框即可获得解密过后的字符串