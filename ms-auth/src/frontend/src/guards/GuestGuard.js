import{ Navigate , useLocation} from "react-router-dom"


const GuestGuard = ({children}) => {
    
    let user = JSON.parse(localStorage.getItem("user"));
    let location = useLocation();

    if(user){
        // redirect to home 
        return <Navigate to="/profile" state={{ from: location }}/>
    }
    return children;
}
 
export default GuestGuard;