# Cn2PyDemo
Android中文转拼音demo，极速！！！
#说明
<li>1.获取索引，即获取中文字符串的第一个字符的首字母，eg.老王：L（非字母字符返回#）
<li>2.获取首字母缩写，eg.老王：l,w（非字母字符返回#）
<li>3.获取全拼，eg.老王：lao,wang（非字母字符返回本身）
<li>4.有500多个生僻汉字都是返回"no"

#版本
2016.08.03 v1.1
<li>1.添加对空格的处理
<li>2.去除返回结果最后的分隔符
<li>2016.08.02 v1.0
##效果图
![p1.png](http://upload-images.jianshu.io/upload_images/1712519-dc6f9a98544cb483.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
![p2.png](http://upload-images.jianshu.io/upload_images/1712519-4e92508aa1d2d688.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
![p3.png](http://upload-images.jianshu.io/upload_images/1712519-5fc8984f9fbdd81c.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

##集成方法
####1.Androdi studio
1.在工程的build.gradle下添加如下配置<br>
```
allprojects{ 
	repositories {
		...
		maven { url "https://jitpack.io" }
		}
	}
```

2.添加依赖
```
dependencies{
	compile 'com.github.heygays:Cn2Py:v1.1'
	}
```
####2.Eclipse
在demo 工程的app目录下有jar

##代码中调用

![Paste_Image.png](http://upload-images.jianshu.io/upload_images/1712519-c02031c60461e6ab.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
