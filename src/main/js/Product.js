import React from 'react';


const Product = ({id, productName, price, description}) => {
    
    return (
        <div>
            <p>{id}, {productName}, {price}, {description}</p>
        </div>
        
    )
}

export default Product;