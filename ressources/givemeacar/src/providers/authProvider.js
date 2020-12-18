// in src/authProvider.js
const authProvider = {
    login: ({username,password})=> Promise.resolve(),
    //checkError: error => Promise.resolve(),
    //checkAuth: params => Promise.resolve(),
    //logout: () => Promise.resolve(),
    //getIdentity: () => Promise.resolve(),
    //getPermissions: params => Promise.resolve(),
};

export default authProvider;