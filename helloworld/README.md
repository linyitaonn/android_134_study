# Android开发实验报告：Hello World应用

**课程名称**：移动应用开发  
**实验项目**：Hello World Android应用开发  
**学号**：134  
**实验日期**：2025/9/28

---

## 一、实验目的

1. 掌握Android Studio开发环境的基本使用方法
2. 学习创建简单的Android应用程序
3. 理解Android项目的基本结构和配置文件
4. 掌握GitHub版本控制的配置方法
5. 熟悉Java在Android开发中的应用

---

## 二、实验环境

| 环境项     | 配置信息             |
|------------|----------------------|
| 开发工具   | Android Studio       |
| 编程语言   | Java                 |
| 构建工具   | Gradle               |
| 目标SDK    | Android API 级别     |
| 版本控制   | GitHub               |

---

## 三、实验内容

### 3.1 项目创建
- 使用Android Studio创建新项目
- 选择Empty Activity模板
- 配置项目名称、包名和保存路径
- 设置最低支持的Android版本

### 3.2 界面设计
- 在 [activity_main.xml](file://D:\data\android_project\app\src\main\res\layout\activity_main.xml) 中设计用户界面
- 添加 `TextView` 控件显示 "Hello World!"
- 配置基本的布局属性

### 3.3 代码实现
- 在 [MainActivity.java](file://D:\data\android_project\layout\src\main\java\com\example\layout\MainActivity.java) 中编写Java代码
- 实现Activity的生命周期方法
- 处理基本的用户界面交互

### 3.4 GitHub配置
- 初始化Git仓库
- 配置 `.gitignore` 文件
- 提交代码到GitHub仓库

---

## 四、核心代码

### 4.1 MainActivity.java
package com.example.helloworld;
import androidx.appcompat.app.AppCompatActivity; 
import android.os.Bundle;
public class MainActivity extends AppCompatActivity { 
@Override 
protected void onCreate(Bundle savedInstanceState) { 
super.onCreate(savedInstanceState); 
setContentView(R.layout.activity_main); 
} 
}
### 4.2 activity_main.xml
xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android" xmlns:app="http://schemas.android.com/apk/res-auto" android:layout_width="match_parent" android:layout_height="match_parent">
<TextView
android:id="@+id/textView"
android:layout_width="wrap_content"
android:layout_height="wrap_content"
android:text="Hello World!"
app:layout_constraintBottom_toBottomOf="parent"
app:layout_constraintLeft_toLeftOf="parent"
app:layout_constraintRight_toRightOf="parent"
app:layout_constraintTop_toTopOf="parent" />
</androidx.constraintlayout.widget.ConstraintLayout>