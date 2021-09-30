// To avoid the callback hell issue, Es6 intoducted Promises
// to allow you to write asynchronous code in a more manageable ways

//A Promise is an object that MAY produce a single value at some point in the future, either resolved of rejected (reject)

// A Promise may be in 1 of 3 possible states:
// 1. fulfilled
// 2. Rejected
// 3. Pending

function getUser(userID){

    return new Promise((resolve,reject)=>{
        console.log('Get User from the DB.')

        setTimeout(()=> {
            resolve({
                userID:userID,
                username: 'John'
            })
        },1000)
    })
    
}

function getServices(user){
    return new Promise((resolve, reject) => {

        console.log(`Get services of ${user.username} from the API`)

        setTimeout(()=>{
            resolve(['Email','VPN','CDN'])
        },2*1000)
    })


}

function getServiceCost(services,callback){
    return new Promise((resolve, reject) => {
        console.log(`Calculate service costs of ${services}.`)

        setTimeout(()=>{
            resolve(services.length *100);
        },3*1000)

    })

}

getUser(103)
.then(getServices)
.then(getServiceCost)
.then(console.log);