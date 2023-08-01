import { useEffect, useState } from "react"
import { getAllDogs } from "../service/dogs-service";


export const AllDogs = () => {
    const [dogs, setDogs] = useState([]);
    useEffect(() => {
        getAllDogs()
        .then(res => {
            console.log(res);
            setDogs(res.data);
        });
    },
        []
    );
    return (dogs.map(dog => 
        <div>
            <div>Name: {dog.name}</div>
            <div>Age: {dog.age}</div>
        </div>
       
    ))
}
