// JS语法--数据类型和变量
//
//  (1)JS变量的声明
//      方式：由于JS是弱类型的语言，因此不管变量的值是什么类型，统统只用var声明变量即可
//      语法：var 变量名 = 值
//      e.g. var i = 10  或  var str = "qwer"
//      注意：1.变量在声明式不指定类型，在赋值时才确定类型
//           2.同一个变量可以反复赋值成不同类型的数据
//           3.JS中，同名变量可以反复声明
//           4.JS变量标识符严格区分大小写，命名规范和Java相同

var i = 10; // JS语句结尾的“;”可加可不加
var str = "qwer";
console.log(i); // 将变量输出到控制台
console.log(str);
var i; // 同名变量可以多次声明

//  (2)常见的数据类型
//      类型如下：
//          1.数值类型number：包括整数、浮点数
//          2.字符串类型string
//          3.布尔类型boolean
//          4.引用类型object
//          5.函数类型function
//          ...
//      注意：
//          1.我们可以通过typeof关键字判断数据类型
//          2.若变量只声明，未赋值，则变量默认为undefined类型，该类型变量不能使用，否则报错
//          3.null空指针变量属于object引用类型

console.log(typeof i); // number
console.log(typeof str); // string
var a;
console.log(typeof a); // undefined
a = null;
console.log(typeof a); // object
a = new Object();
console.log(typeof a); // object
a = 1 > 2;
console.log(typeof a); // boolean
a = function () {};
console.log(typeof a); // function
