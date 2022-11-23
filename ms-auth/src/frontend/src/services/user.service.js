/* 
Now we define a service for accessing data in services/user.service.js 
*/ 
/*
- You can see that we add a HTTP header with the help of authHeader() function 
when requesting authorized resource. 
*/


import axios from "axios";
import authHeader from "./auth-header";

const API_URL = "http://localhost:8777/api/test/";

const getPublicContent = () => {
  return axios.get(API_URL + "all");
};

const getUserBoard = () => {
  return axios.get(API_URL + "user", { headers: authHeader() });
};

const getAdminBoard = () => {
  return axios.get(API_URL + "admin", { headers: authHeader() });
};

const UserService = {
  getPublicContent,
  getUserBoard,
  getAdminBoard,
};

export default UserService;