# Android Layout项目实验报告

**课程名称**：移动应用开发  
**实验项目**：Android布局学习与实践  
**学号**：134  
**实验日期**：2025/9/28

---

## 一、实验目的

1. 掌握Android中常用布局的使用方法
2. 学习LinearLayout、ConstraintLayout、TableLayout等布局的特点和应用场景
3. 理解不同布局的嵌套使用和约束关系
4. 熟悉Android界面设计的基本原则

---

## 二、实验环境

| 环境项     | 配置信息             |
|------------|----------------------|
| 开发工具   | Android Studio       |
| 编程语言   | XML                  |
| 构建工具   | Gradle               |
| 目标SDK    | Android API 级别     |

---

## 三、实验内容

### 3.1 LinearLayout布局 ([linearlayout.xml](file://D:\data\android_project\layout\src\main\res\layout\linearlayout.xml))

使用 `LinearLayout` 创建了一个网格布局，具有以下特点：
- 采用垂直方向的外层布局，包含四个水平排列的行
- 每行包含四个等宽的 `TextView` 元素
- 设置了黑色背景和白色文本，形成高对比度显示效果
- 通过 `layout_marginRight` 和整体 `padding` 实现元素间的间距

### 3.2 ConstraintLayout布局 ([constraintlayout.xml](file://D:\data\android_project\layout\src\main\res\layout\constraintlayout.xml))

使用 `ConstraintLayout` 创建了一个简易计算器界面，具有以下特点：
- 通过约束关系精确定位每个控件的位置
- 包含一个结果显示区域和数字按键(0-9)
- 设置了运算符按钮(+、-、×、÷)
- 利用 `layout_constraintHorizontal_weight` 属性实现按钮的均匀分布

### 3.3 TableLayout布局 ([tablelayout.xml](file://D:\data\android_project\layout\src\main\res\layout\tablelayout.xml))

使用 `TableLayout` 创建了一个类似菜单的界面，具有以下特点：
- 采用表格形式组织内容，每行包含标签和快捷键信息
- 使用 `stretchColumns` 属性使第一列自动拉伸填充可用空间
- 设置了黑色背景和白色文本，提高可读性
- 包含标题行和多个功能选项行

### 3.4 复杂ConstraintLayout布局 ([constraintlayout2.xml](file://D:\data\android_project\layout\src\main\res\layout\constraintlayout2.xml))

使用 `ConstraintLayout` 创建了一个太空旅行预订界面，具有以下特点：
- 结合多种控件类型：`ImageView`、`TextView`、`Switch`、`Button`
- 实现了顶部导航栏、出发目的地选择、单程选项开关等功能模块
- 通过复杂的约束关系实现响应式布局
- 使用不同颜色标识不同功能区域（绿色表示地点、橙色表示选项、紫色表示按钮）

---

## 四、核心代码说明

### 4.1 LinearLayout关键特性
```xml
<LinearLayout
    android:orientation="vertical"
    android:background="#000000">
    
    <LinearLayout
        android:orientation="horizontal">
        <!-- 子元素 -->
    </LinearLayout>
</LinearLayout>
```


### 4.2 ConstraintLayout关键特性
```xml
<androidx.constraintlayout.widget.ConstraintLayout>
    <TextView
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />
</androidx.constraintlayout.widget.ConstraintLayout>
```


### 4.3 TableLayout关键特性
```xml
<TableLayout
    android:stretchColumns="0">
    
    <TableRow>
        <TextView />
        <TextView />
    </TableRow>
</TableLayout>
```


---

## 五、实验总结

通过本次实验，掌握了Android开发中三种主要布局方式的特点和使用场景：
1. `LinearLayout`适合简单线性排列的界面
2. `ConstraintLayout`适合复杂精确定位的界面
3. `TableLayout`适合表格形式的数据展示

这些布局方式各有优势，在实际开发中可根据需求灵活选择和组合使用。