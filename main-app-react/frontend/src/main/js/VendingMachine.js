import React, {useState, useEffect} from 'react';
import { makeStyles } from '@material-ui/core/styles';
import Card from '@material-ui/core/Card';
import CardActions from '@material-ui/core/CardActions';
import CardContent from '@material-ui/core/CardContent';
import Button from '@material-ui/core/Button';
import Typography from '@material-ui/core/Typography';
import { useMediaQuery } from '@material-ui/core/';
import Product from './Product';
const useStyles = makeStyles({
    root: {
        maxWidth: 600,
        height:800,
        background:'lightgray',
        margin:'1em auto',
      },
      rootMobile: {
        height:800,
        maxWidth: 300,
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


const VendingMachine = ({id, owner, inventory}) => {
    const classes = useStyles();
    const isDesktop = useMediaQuery('(max-width:900px)');
    return (
        <Card className={isDesktop ? classes.root : classes.rootMobile}>
            <CardContent justify='content'>
                <Typography variant="body2">Vending Machine Id:{id}</Typography>
                <Typography>Owner: {owner}</Typography>
                <Typography variant="body2">Products:</Typography>
                {Object.keys(inventory).map(productId => (
                    <Product 
                      id={productId} 
                      quantity={inventory[productId]}
                    />
                ))}
            </CardContent>
        </Card>
        
    )
}

export default VendingMachine;