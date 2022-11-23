/*
Authentication service :
The service uses Axios for HTTP requests and Local Storage for user information & JWT.
It provides following important functions:

- login(): POST {username, password} & save JWT to Local Storage
- logout(): remove JWT from Local Storage
- register(): POST {username, email, password}
- getCurrentUser(): get stored user information (including JWT)
*/


import axios from "axios";

const API_URL = "http://localhost:8777/api/auth/";

const register = (username, email, password) => {
  return axios.post(API_URL + "signup", {
    username,
    email,
    password,
  });

};

const login = async (username, password) => {
  const response = await axios
    .post(API_URL + "signin", {
      username,
      password
    });
  if (response.data.token) {
    let val = JSON.stringify(response.data);
    console.log(val);
    window.localStorage.setItem("user", val);
  }
  return response.data;  
};

const logout = () => {
  localStorage.removeItem("user");
};



const getCurrentUser = () => {
  return JSON.parse(localStorage.getItem('user'));
};

const AuthService = {
  register,
  login,
  logout,
  getCurrentUser,
};

export default AuthService;