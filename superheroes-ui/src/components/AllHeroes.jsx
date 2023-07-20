import React, { useEffect, useState } from 'react'
import Row from 'react-bootstrap/Row'
import HeroDetail from './HeroDetail'
import { getAllHeroes } from '../services/hero-service';

const AllHeroes = () => {
    const [total, setTotal] = useState(0);
    const [heroes, setHeroes] = useState([]);

    const totalCountHandler = (name) => {
        console.log(name)
        setTotal(total + 1);
    }

    useEffect(() => {
        getHeroesFromAPI();
    }, []
    );

    const getHeroesFromAPI = () => {
        getAllHeroes()
            .then(res => {
                setHeroes(res.data);
            })
            .catch(err => {
                setHeroes([]);
                console.log(err);
            })
    }

    return (
        <>
            <h1>Total count is: {total}</h1>
            <Row xs={4}>
                {heroes.map(hero => {
                    return (<div className='container' key={hero.id}>
                        <HeroDetail info={hero} parentCount={totalCountHandler} />
                    </div>);
                })}
            </Row>
        </>
    )
}

export default AllHeroes