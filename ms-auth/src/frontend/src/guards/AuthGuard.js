import{ Navigate , useLocation} from "react-router-dom"


const AuthGuard = ({children}) => {

    let user = JSON.parse(localStorage.getItem("user"));
    let location = useLocation();
    
    if(!user){
        console.log("login is required");
        return <Navigate to="/login" state={{ from: location }}/>
    }
    else if(location.pathname==="/admin" && user.roles[0] === "ROLE_USER" ){
        console.log("unauthorized");
        return <Navigate to="/unauthorized" state={{ from: location }}/>;
    }
    return children;
}
 
export default AuthGuard;