import React, { useState, useEffect } from 'react';
import './css/Container.css';
import Product from './Product';
const Container = () => {
    const [hasError, setErrors] = useState(false);
    const [products, setProducts] = useState([]);
    const [product, setProduct] = useState("");
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
    useEffect(() =>{
        async function fetchData(){
            const res = await fetch("/products/1");
            res
                .json()
                .then(res => {
                    setProduct(res)
                })
                .catch(err => setErrors(err));

        }
        fetchData();
    }, [])
    
    const {id, productName, price, description} = product;
    return (
        <div>
            {
                !products.length ? //wait for products to have data
                    <h1>Loading Data...</h1>
                    :
                    products.map(someProduct => (
                        <div>
                        <Product key={someProduct.id} id={someProduct.id} productName={someProduct.productName} price={someProduct.price} description={someProduct.description}/>
                        </div>
                    ))
                }
            <div>
                <Product key={id} id={id} productName={productName} price={price} description={description}/>
            </div>
        </div>
    )
}

export default Container;