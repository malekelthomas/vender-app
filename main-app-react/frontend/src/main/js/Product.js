import React, {useState, useEffect} from 'react';
import { makeStyles } from '@material-ui/core/styles';
import Card from '@material-ui/core/Card';
import CardActions from '@material-ui/core/CardActions';
import CardContent from '@material-ui/core/CardContent';
import Button from '@material-ui/core/Button';
import Typography from '@material-ui/core/Typography';
import { useMediaQuery } from '@material-ui/core/';

const useStyles = makeStyles({
    root: {
        maxWidth: 300,
        height:700,
        background:'lightgray',
        margin:'1em auto',
      },
      rootMobile: {
        height:700,
        maxWidth: 200,
        background:'lightgray',
        margin:'1em auto',
        padding:50
      },
      bullet: {
        display: 'inline-block',
        margin: '0 2px',
        transform: 'scale(0.8)',
      },
      title: {
        fontSize: 14,
      },
      pos: {
        marginBottom: 12,
      },
});

const Product = ({id, quantity}) => {
    const [product, setProduct] = useState("");
    useEffect(() => {
        async function fetchProduct(){
            const res = await fetch(`/products/${id}`);
            res
                .json()
                .then(res => {
                    setProduct(res)
                })
                .catch(err => setErrors(err));
    
        }
        fetchProduct();
    }, [])
    
    return (
        <div>
            <Typography variant="body2">ProductID:{product.id} Product Name:{product.productName} Price:{product.price} Product Description:{product.description} Quantity: {quantity}</Typography>
        </div>
        
    )
}

export default Product;