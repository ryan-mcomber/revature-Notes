//javascript execution context
// every time a JS engine executes a script, an execution context is built
//this execution context has 2 phases: creation, execution

let x = 10; //declared! (initialized and assigned a value)

function timesTen(a) {
    return a*10;
}

let y = timesTen(x);

console.log(y);

/**
 * Creation Phase
 * 
 * 1. Create the Global Object - web browser (window) -> Node = global object
 * 
 * 2. Bing "this" to the Global Object
 * 
 * 3. Setup a memory heap for storing variables and function references.
 * 
 * 4. Store the function declaration in the memory heap. Store variables within global execution context as undefined (initialized but not declared)
 * 
 */

/** 
 * Execution Phase
 * 
 * JavaScript engine executes the code line by line. In this phase, it assigns values to variables
 * and executes the function calls.
 * 
 */

//Variable hoisting
console.log(a);
var a = 1;

console.log(b);
let b =1;

// are variables declared with let & const hoisted?
// All declaration are hoisted in JavaScript...

/** 
 * While VAR variables are initialiazed, they remain undefined,
 * but let and const remain uninitialized; -> so they throw an error.
 * 
 */