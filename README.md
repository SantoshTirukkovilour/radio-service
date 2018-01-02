# radio-service


Android service library which uses AAC Player. Ready to use Radio Player Service. (Android Background Player Service)

## Features ##
- Play and stop live radio streams on background.
- Handle incoming and outgoing calls.

## Supported URLs

- http://xxxx:1232
- http://xxxx/abc.pls
- http://xxxx/abc.ram
- http://xxxx/abc.wax
- http://xxxx/abc.m4a
- http://xxxx/abc.mp3

## Unsupported URLs (yet)

NOTE : Some of below urls might have embedded player inside webpage. We can inspect page and check if it has any url
which is supported by this library. I will try to do that next commits.

- rtmp://xxxx
- http://xxxx/abc.aspx
- http://xxxx/abc.php
- http://xxxx/abc.html
- mms://xxxx


# Usage #

## Gradle ##
```
repositories {
    maven {
        url "https://jitpack.io"
    }
}
```

```
dependencies {
    compile 'com.github.SantoshTirukkovilour:radio-service:1.0.1'
}
```
## Using Radio Service ##

In your Activity

```java
RadioManager mRadioManager = RadioManager.with(this);
```
```java
//Invoke it #onCreate
mRadioManager.registerListener(this);
```
```java
//Enables notification or you can disable it 
//giving "false" parameter
mRadioManager.enableNotification(true);
```
```java
//Invoke it #onStart
mRadioManager.connect();
```
```java
//Invoke it #onDestroy
mRadioManager.disconnect();
```

Play and pause radio like 
```java
//starts radio streaming.
mRadioManager.startRadio(RADIO_URL);
//stop radio streaming.
mRadioManager.stopRadio();
```
Implement `RadioListener` to get notified on radio state changed.
```java
public class MainActivity extends Activity implements RadioListener
...
 @Override
    public void onRadioStarted() {
        
    }

    @Override
    public void onRadioStopped() {
        
    }

    @Override
    public void onMetaDataReceived(String s, String s1) {
        
    }
...
```

Demo project will help you to understand implementation.

## Libraries Used ##

[AAC Decoder Library](https://github.com/vbartacek/aacdecoder-android)

[RadioPlayerService](https://github.com/iammert/RadioPlayerService)
