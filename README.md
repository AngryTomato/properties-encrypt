# properties-encrypt
encrypt application.properties in springboot

该工具是为了自己更加方便的加密SpringBoot中的配置文件。

本工具利用`jasypt-spring-boot`，使用的版本为`3.0.2`.



## 使用指南

1.项目启动前，需要在`application.properties`中配置：

```
jasypt.encryptor.password=
jasypt.encryptor.algorithm=
```

其中支持的算法可以参考`jasypt-spring-boot`文档。

2.在上方文本框中填写待加密的字符串（例如：mysql的用户名**root**），然后点击加密，下方文本框即可获得加密过后的Base64字符串。

3.在下方文本框中填写已加密的Base64字符串，然后点击解密，上方文本框即可获得解密过后的字符串。