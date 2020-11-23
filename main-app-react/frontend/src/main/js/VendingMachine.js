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
        margin:'10em auto',
      },
      rootMobile: {
        height:800,
        maxWidth: 300,
        background:'lightgray',
        margin:'10em auto',
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


const VendingMachine = ({match}) => {
    const classes = useStyles();
    const isDesktop = useMediaQuery('(max-width:900px)');
    const {id} = match.params;
    const [vendingMachines, setVendingMachines] = useState([]);
    const [vendingMachine, setVendingMachine] = useState("");
    const [error, setErrors] = useState([]);
    useEffect(() =>{
      async function fetchVendingMachines(){
        if(id != null){
          const res = await fetch(`/vendingmachines/${id}`)
          res
            .json()
            .then(res => {
              console.log(res)
              console.log(id) 
              setVendingMachine(res)
            })
            .catch(err => setErrors(err));

        }
        else{
          const res = await fetch("/vendingmachines/")
          res
            .json()
            .then(res => {
              console.log(res)
              setVendingMachines(res.data);
            })
            .catch(err => setErrors(err));
          }

      }
      fetchVendingMachines();
    }, [match.params.id]) //updates when id changes


    return (
    
        id && vendingMachine != "" ?
        <Card className={isDesktop ? classes.root : classes.rootMobile}>
          {console.log(vendingMachine)}
            <CardContent justify='content'>
                <Typography variant="body2">Vending Machine Id:{vendingMachine.id}</Typography>
                <Typography>Owner: {vendingMachine.owner}</Typography>
                <Typography variant="body2">Products:</Typography>
                {Object.keys(vendingMachine.inventory).map(productId => (
                  <Product 
                  id={productId} 
                  quantity={vendingMachine.inventory[productId]}
                  />
                  ))}
            </CardContent>
          </Card>
          :

        vendingMachines.map(someVendingMachine=> (
          <Card className={isDesktop ? classes.root : classes.rootMobile}>
            <CardContent justify='content'>
                <Typography variant="body2">Vending Machine Id:{someVendingMachine.id}</Typography>
                <Typography>Owner: {someVendingMachine.owner}</Typography>
                <Typography variant="body2">Products:</Typography>
                {Object.keys(someVendingMachine.inventory).map(productId => (
                  <Product 
                  id={productId} 
                  quantity={someVendingMachine.inventory[productId]}
                  />
                  ))}
            </CardContent>
          </Card>
      ))
        
    )
}

export default VendingMachine;