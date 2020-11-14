import React, { useState, useEffect } from 'react';
import './css/Container.css';
import Product from './Product';
const Container = () => {
    const [hasError, setErrors] = useState(false);
    const [products, setProducts] = useState([]);
    useEffect(() =>{
        async function fetchData(){
            const res = await fetch("/products");
            res
                .json()
                .then(res => {
                    setProducts(res.data)
                })
                .catch(err => setErrors(err));

        }
        fetchData();
    }, [products])
    
    return (
        <div>
            {
                !products.length ? //wait for products to have data
                    <h1>Loading Data...</h1>
                    :
                    products.map(product => (
                        <div>
                        <Product key={product.id} id={product.id} productName={product.productName} price={product.price} description={product.description}/>
                        </div>
                    ))
            }
        </div>
    )
}

export default Container;