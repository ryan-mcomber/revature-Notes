//Introduction to JavaScript asyn/await
// Star from Zero: Life before Promises

/**
 * In the past when you wanted to deal with asynchronous operations, you have to use callback functions.
 * When you nest multiple callback function, the code becomes very difficult to maintain.,
 * This very issue is called callback hell.
 * 
 * Suppose you want to perform 3 asynchronous ops:
 * 
 * 1. Select a user from a db
 * 2. Get Services of the User (we're checking what internet services the user has used)
 * 3. Calculate service costbased on the services the user has used.
 */

//getUser
function getUser(userId, callback){
    console.log('Get user from the database.')

    setTimeout(() => {
        callback({
            userId: userId,
            username: 'John'
        })
    },1000) //first in line in the callback queue
}

//getService


//getServiceCost
function getServiceCost(services,callback){
    console.log(`Calculate service costs of ${services}.`)

    setTimeout(()=>{
        callback(services.length *100);
    },3*1000)
}

//nest all function together to get the full amount owed by the User
//nested services to get the final cost that the User owes for services borrowed

getUser(104,(user) => {
    //the "2nd paramater is a function (callback function)"
    getServices(user,(services) => { //implementing callback as 2nd param for getServices()
        getServiceCost(services, (cost) =>{ // implementing callback as 2nd param for getServiceCost();
            console.log(`the service cost is ${cost}`)
        })
    })
})