import React, { useState, useEffect } from 'react';
import './css/Container.css';
import Product from './Product';
import VendingMachine from './VendingMachine';
const Container = () => {
    const [hasError, setErrors] = useState(false);
    const [products, setProducts] = useState([]);
    const [vendingMachines, setVendingMachines] = useState([]);
    useEffect(() =>{
        async function fetchProducts(){
            const res = await fetch("/products/");
            res
                .json()
                .then(res => {
                    setProducts(res.data)
                })
                .catch(err => setErrors(err));

        }
        async function fetchVendingMachines(){
            const res = await fetch("/vendingmachines/");
            res
                .json()
                .then(res => {
                    setVendingMachines(res.data)
                })
                .catch(err => setErrors(err));

        }
        fetchVendingMachines();
        fetchProducts();
    }, [])
    

    return (
        <div>
                {
                    !vendingMachines.length ?
                    <h1>Loading Vending Machines...</h1>
                    :
                    vendingMachines.map(someVendingMachine => (
                        <div>
                            <VendingMachine 
                                key={someVendingMachine.id} 
                                id={someVendingMachine.id} 
                                owner={someVendingMachine.owner} 
                                inventory={someVendingMachine.inventory}
                            />
                        </div>
                    ))
                }
        </div>
    )
}

export default Container;