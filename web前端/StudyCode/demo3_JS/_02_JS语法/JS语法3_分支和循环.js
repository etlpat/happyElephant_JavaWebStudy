// JS语法--分支和循环
//
// 1.分支结构
//  JS的分支结构和其它语言规则相同
//  语法：（同理，switch语法也相同）
//  if () {
//      代码块
//  } else if () {
//      代码块
//  } else {
//      代码块
//  }
//
//
// 2.循环结构
//  语法：普通的for和while语法同其它语言一致
//    for ( var i = 0; i <= 10; i++ ) {...}
//    while ( true ) {...}
//  注意：JS的for-each迭代器循环和Java不同
//    语法：for (var index in arr) {...}
//    该循环中每次的index，表示数组元素下标，而非数组元素；并且需要关键字in来获取下标
//
//
//
// 注意事项：
//  1.弹出框prompt
//      语法：var 变量 = prompt("提示信息");
//      功能：在网页上弹出提示信息和输入框，当用户输入值后，prompt将该值返回给变量
//      注意：prompt默认将用户输入的值以string的形式返回，之后在比较数字时，系统会对该值进行自动类型转换
//  2.将变量转化为boolean值
//      非空字符串，等价于true
//      空字符串""，等价于false
//      非0数字，等价于true
//      0，等价于false
//  3.document.write("html语言")
//      以上语法，可以向网页输出html语言
//      如：document.write("<h1>哈哈</h1>")，可以向网页输出h1标题

function judgeAge(num) {
  if (num < 0) {
    console.log("无效年龄");
  } else if (num <= 18) {
    console.log("少年");
  } else if (num <= 35) {
    console.log("青年");
  } else if (num <= 55) {
    console.log("壮年");
  } else {
    console.log("老年");
  }
}

judgeAge(-1);
judgeAge(15);
judgeAge(27);
judgeAge(46);
judgeAge(77);
// var age = prompt("请输入年龄："); // 在网页弹出输入框，返回用户输入的信息
// console.log("输入的值为" + age);
// judgeAge(age);
// // prompt输入框返回的值默认是字符串类型，可以用Number.parseInt()方法将变量转化为整型
// console.log(typeof age); // string
// var age1 = Number.parseInt(age);
// console.log(typeof age1); // number
console.log("-------------------");

if ("false") {
  // 非空字符串，值为true
  console.log(true); // true
} else {
  console.log(false);
}
if ("") {
  console.log(true);
} else {
  console.log(false); // false
}
if (-1) {
  console.log(true); // true
} else {
  console.log(false);
}

console.log("-------------------");

// 向网页打印乘法口诀表
for (var i = 1; i < 10; i++) {
  for (var j = 1; j <= i; j++) {
    document.write(j + "*" + i + "=" + j * i + "&nbsp;&nbsp;");
  }
  document.write("<hr/>");
}

console.log("-------------------");

// 定义数组（JS的数组，就是python中的列表）
var arr = ["123", "qwe", "asd", 123, new Object()];
// for循环遍历数组
for (var i = 0; i < arr.length; i++) {
  console.log(arr[i]);
}
// for each迭代器遍历列表
for (var index in arr) {
  console.log(arr[index]);
}

console.log("-------------------");
