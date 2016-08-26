[![Build Status](https://travis-ci.org/bluefinframework/bluefin-gradle-plugin.svg?branch=master)](https://travis-ci.org/bluefinframework/bluefin-gradle-plugin)

> Gradle plugin for Bluefin server to upload apk and mapping file.

## Install

* Add the dependencies in rootProject:

		classpath 'cn.saymagic:bluefin-gradle-plugin:2.8.1'
	
* Referenced the plugin in project:

		apply plugin: 'bluefin-plugin'
	
* Add bluefin description in gradle file:

		bluefin{
    		host = '***'
    		apkPath = '***'
    		mappingPath = '***'
		}
		
## Useage

	gradle bluefinuplod

## Licence

[gpl-3.0](https://opensource.org/licenses/gpl-3.0.html)