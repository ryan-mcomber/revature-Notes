//JavaScript in Single Threaded! Con only do One thing at a certain point in time.

/**
 * JS Engine executes a script from the top of a file.
 * 
 * creates the execution contexts and pushes and pops function onto and off the call stack in the execution process.
 * 
 * 
 * 
 */

function task(message){

    //emulate a time consuming task
    let n = 10000000000;

    while(n>0){
        n--;
    }
    console.log(message);
}

// console.log("Start script...");
// task("download complete.");
// console.log("Done!");

// Callbacks to the rescue!!!!
console.log("Start script...");

setTimeout(()=>{
    // a callback function is a function passed as a parameter to another function
    task('Download complete.')
},5);
console.log("Done!");

console.log('Hi');

setTimeout(() => {
    console.log('execute immediately!')

    //this will only execture after all other function have been removed from the stack
    // it hangs out in the callback queue until the call stack is free and its timer has expired
    
},0); //we are not setting any amount of time

console.log('Bye');
