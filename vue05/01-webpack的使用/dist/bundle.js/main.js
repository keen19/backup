/*
 * ATTENTION: The "eval" devtool has been used (maybe by default in mode: "development").
 * This devtool is neither made for production nor for readable output files.
 * It uses "eval()" calls to create a separate source file in the browser devtools.
 * If you are trying to read the output file, select a different devtool (https://webpack.js.org/configuration/devtool/)
 * or disable the default devtool with "devtool: false".
 * If you are looking for production-ready output files, see mode: "production" (https://webpack.js.org/configuration/mode/).
 */
/******/ (() => { // webpackBootstrap
/******/ 	var __webpack_modules__ = ({

/***/ "./src/main.js":
/*!*********************!*\
  !*** ./src/main.js ***!
  \*********************/
/***/ ((module, __unused_webpack_exports, __webpack_require__) => {

eval("var __dirname = \"/\";\nconst  {add,mul} = __webpack_require__(/*! ./mathUtils */ \"./src/mathUtils.js\")\r\n\r\nconsole.log(add(20,30));\r\nconsole.log(mul(20,30));const path = __webpack_require__(Object(function webpackMissingModule() { var e = new Error(\"Cannot find module 'path'\"); e.code = 'MODULE_NOT_FOUND'; throw e; }()))\r\nmodule.exports = {\r\n    entry: path.join(__dirname, './src/app.js'),// 入口，表示，要使用 webpack 打包哪个文件\r\n    output: { // 输出文件相关的配置\r\n        path: path.join(__dirname, './dist'), // 指定 打包好的文件，输出到哪个目录中去\r\n        filename: 'bundle.js' // 这是指定 输出的文件的名称\r\n    }\r\n}\n\n//# sourceURL=webpack:///./src/main.js?");

/***/ }),

/***/ "./src/mathUtils.js":
/*!**************************!*\
  !*** ./src/mathUtils.js ***!
  \**************************/
/***/ ((module) => {

eval("function add(num1, num2) {\r\n    return num1+num2\r\n}\r\n\r\nfunction mul(num1, num2) {\r\n    return num2 * num1\r\n}\r\n\r\nmodule.exports = {\r\n    add,mul\r\n}\n\n//# sourceURL=webpack:///./src/mathUtils.js?");

/***/ })

/******/ 	});
/************************************************************************/
/******/ 	// The module cache
/******/ 	var __webpack_module_cache__ = {};
/******/ 	
/******/ 	// The require function
/******/ 	function __webpack_require__(moduleId) {
/******/ 		// Check if module is in cache
/******/ 		var cachedModule = __webpack_module_cache__[moduleId];
/******/ 		if (cachedModule !== undefined) {
/******/ 			return cachedModule.exports;
/******/ 		}
/******/ 		// Create a new module (and put it into the cache)
/******/ 		var module = __webpack_module_cache__[moduleId] = {
/******/ 			// no module.id needed
/******/ 			// no module.loaded needed
/******/ 			exports: {}
/******/ 		};
/******/ 	
/******/ 		// Execute the module function
/******/ 		__webpack_modules__[moduleId](module, module.exports, __webpack_require__);
/******/ 	
/******/ 		// Return the exports of the module
/******/ 		return module.exports;
/******/ 	}
/******/ 	
/************************************************************************/
/******/ 	
/******/ 	// startup
/******/ 	// Load entry module and return exports
/******/ 	// This entry module is referenced by other modules so it can't be inlined
/******/ 	var __webpack_exports__ = __webpack_require__("./src/main.js");
/******/ 	
/******/ })()
;