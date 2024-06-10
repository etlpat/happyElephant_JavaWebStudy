// JS语法--创建对象
//
// 语法：
//  1.创建对象语法：
//      方式1：var 对象 = new Object()
//      方式2：var 对象 = { 属性名1:属性值1, 属性名2:属性值2,... }
//  2.为对象添加属性/方法：
//      ①为对象添加属性：
//          语法：对象名.属性名=值
//          功能：若对象没有该属性，则添加该属性，并为其赋值；若对象有该属性，则直接为其赋值
//          e.g. object1.name="张三"
//      ②为对象添加方法：
//          语法：对象名.方法名=function(...){...}
//          功能：若对象没有改方法，则添加该方法；若对象有该方法，则覆盖该方法
//          e.g. object1.getName=function(){ return this.name }
//
//
// 注意：
//  1.其它语言中，都是通过类来实例化对象
//    JS语法中，没有类这一概念，对象是直接创建的，之后可以再为该对象添加属性、方法

// 创建对象
var person = new Object();
person.name = "张三"; // 为对象添加属性
person.getName = function () {
  // 为对象添加方法
  return this.name;
};
console.log(person.name);
console.log(person.getName());

console.log("-------------------");

// 通过{键值对}的形式创建对象
var cat = {
  name: "小白",
  eat: function () {
    console.log(this.name + "在吃鱼");
  },
};
console.log(cat.name);
cat.eat();

cat.eat = function () {
  // 新方法覆盖旧方法
  console.log("666");
};
cat.eat();

console.log("-------------------");
