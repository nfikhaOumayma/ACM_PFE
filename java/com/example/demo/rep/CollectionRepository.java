package com.example.demo.rep;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.CollectionDTO;
import com.example.demo.entity.AcmCollection;

@Repository
public interface CollectionRepository extends JpaRepository<AcmCollection, Long> {

    @Query(value = "SELECT new com.example.demo.dto.CollectionDTO("
            + "collection.id, "
            + "collection.typeCustomer, "
            + "collection.customerIdExtern, "
            + "collection.accountNumber, "
            + "collection.productDescription, "
            + "collection.customerName, "
            + "collection.branchDescription, "
            + "collection.amount, "
            + "collection.loanOfficer, "
            + "collection.firstUnpaidInstallment, "
            + "collection.unpaidAmount, "
            + "collection.lateDays, "
            + "collection.numberOfUnpaidInstallment, "
            + "collection.status, "
            + "collection.idAcmCollectionStep, "
            + "collection.productId, "
            + "collection.branchId, "
            + "collection.currencySymbol, "
            + "collection.currencyDecimalPlaces, "
            + "collection.idLoanExtern, "
            + "collection.availableDate, "
            + "collection.owner, "
            + "collection.ownerName, "
            + "collection.groupOwner, "
            + "collection.groupOwnerName, "
            + "collection.collectionType, "
            + "collection.idParentCollection, "
            + "collection.statutLibelle, "
            + "collection.statutLibelleDone, "
            + "collection.statutWorkflow"
            + ",GETDATE()) " 
            + "FROM AcmCollection collection")
    List<CollectionDTO> getCollections();
    
    
}
