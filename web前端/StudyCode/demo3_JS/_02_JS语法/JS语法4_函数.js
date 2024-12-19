// JS语法--函数
//
//  语法：
//      方式1：function 函数名() {}
//      方式2：var 变量名 = function() {}
//  特点：
//      1.没有访问修饰符
//      2.没有返回类型，若想返回，直接return即可
//      3.形参不能用var声明，直接填变量即可
//      4.没有异常列表
//  注意：
//      1.调用方法时，实参和形参的数量可以不一致
//          若实参多于形参，则形参只接收前几个实参，后面的相对于没写
//          若形参多于实参，则没被传参的形参，类型默认是undefined类型
//      2.函数也可以作为参数，被传递给另一个方法
//

// 声明函数
function sum1(a, b) {
  return a + b;
}
var sum2 = function (a, b, c) {
  console.log(typeof c);
  return a + b;
};

console.log(sum1(10, 20, 30)); // 实参多于形参，多出来的实参不会被接收
console.log(sum2(30, 40)); // 形参多于实参，没传参的形参类型为undefined

console.log("-------------------");

// 函数作为参数被传递
function sumAll(a, b, c, func) {
  return a + func(b, c);
}
console.log(sumAll(1, 20, 300, sum1)); // 321
console.log(sumAll(1, 20, 300, sum2)); // 321

console.log("-------------------");
