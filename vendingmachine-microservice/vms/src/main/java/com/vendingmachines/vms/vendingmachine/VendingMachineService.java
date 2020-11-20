package com.vendingmachines.vms.vendingmachine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VendingMachineService {

    /**
     * 
     */
    private static final String DATA = "data";
    @Autowired
    private VendingMachineRepository vmRepository;

    private static ArrayList<VendingMachine> vms = new ArrayList<>();

    private static Map<String, ArrayList<VendingMachine>> vmsData;
    static {
        vmsData = new HashMap<String, ArrayList<VendingMachine>>();
        vmsData.put(DATA, vms);
    }

    public Map<String, ArrayList<VendingMachine>> getAllVendingMachines(){
        
        ArrayList<VendingMachine> vms = new ArrayList<>();
        vmRepository.findAll()
        .forEach(vms::add);
        Map<String, ArrayList<VendingMachine>> vmsData = new HashMap<String, ArrayList<VendingMachine>>();
        {
            vmsData = new HashMap<String, ArrayList<VendingMachine>>();
            vmsData.put(DATA, vms);
        }
        return vmsData;

    }

    public VendingMachine getVendingMachine(Integer id){
        VendingMachine vm = vmRepository.findById(id)
        .orElse(null);

        return vm;
    }

    public void registerVendingMachine(VendingMachine vm){
        vmsData.computeIfAbsent(DATA, k -> new ArrayList<>()).add(vm);
        vmRepository.save(vm);
        System.out.println(vmsData.get(DATA));
    }

    public void addProductToInventory(Integer vmId, Integer productId){
        VendingMachine vm = getVendingMachine(vmId);
        vm.addToInventory(productId);
        vmRepository.save(vm);

    }
    
}
