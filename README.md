# Cn2PyDemo
Android中文转拼音demo，极速！！！

##效果图
![p1.png](http://upload-images.jianshu.io/upload_images/1712519-dc6f9a98544cb483.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
![p2.png](http://upload-images.jianshu.io/upload_images/1712519-4e92508aa1d2d688.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
![p3.png](http://upload-images.jianshu.io/upload_images/1712519-5fc8984f9fbdd81c.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

##集成方法
####1.Androdi studio
1.在工程的build.gradle下添加如下配置<br>
<code><br>
allprojects {<br>
		repositories {{<br>
			...<br>
			maven { url "https://jitpack.io" }{<br>
		}{<br>
	}{<br>
</code>
2.添加依赖<br>
<code><br>
dependencies {<br>
	        compile 'com.github.heygays:Cn2Py:v1.0'<br>
	}<br>
</code><br>
####2.Eclipse
在demo 工程的lib下有jar

##代码中调用

![Paste_Image.png](http://upload-images.jianshu.io/upload_images/1712519-c02031c60461e6ab.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
