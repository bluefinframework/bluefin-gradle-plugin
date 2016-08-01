
> Gradle plugin for Bluefin server to upload apk and mapping file.

## Install

* 在rootProject的dependencies中添加

		classpath 'cn.saymagic:bluefin-plugin:2.7'
	
* 项目中引用插件

		apply plugin: 'bluefin-plugin'
	
* 项目中添加bluefin的描述：

		bluefin{
    		host = '***'
    		apkPath = '***'
    		mappingPath = '***'
		}
		
## Useage

	gradle bluefinuplod

## Licence

[gpl-3.0](https://opensource.org/licenses/gpl-3.0.html)