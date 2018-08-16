/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.sitop.Controller;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author angelo
 */
public class GenerateHash {
    
    public static HashMap<String, ArrayList<String>> createHashMap(){
        HashMap<String, ArrayList<String>> hm = new HashMap<>();
        
        ArrayList<String> BOOSTER = new ArrayList<>();
        BOOSTER.add("BOOSTERGasIndicator");
        BOOSTER.add("GasTreatmentArea");
        hm.put("BOOSTER", BOOSTER);
        
        ArrayList<String> BSWA = new ArrayList<>();
        BSWA.add("BSWAOilIndicator");
        BSWA.add("OilTreatmentArea");
        hm.put("BSW_A", BSWA);
        
        ArrayList<String> BSWB = new ArrayList<>();
        BSWB.add("BSWBOilIndicator");
        BSWB.add("OilTreatmentArea");
        hm.put("BSW_B", BSWB);
        
        ArrayList<String> BSWENT = new ArrayList<>();
        BSWENT.add("BSWENTOilIndicator");
        BSWENT.add("OilTreatmentArea");
        hm.put("BSW_ENT", BSWENT);
        
        ArrayList<String> BSW = new ArrayList<>();
        BSW.add("BSWOilIndicator");
        BSW.add("OilTreatmentArea");
        hm.put("BSW", BSW);
        
        ArrayList<String> BSWSAI = new ArrayList<>();
        BSWSAI.add("BSWSAIOilIndicator");
        BSWSAI.add("OilTreatmentArea");
        hm.put("BSW_SAI", BSWSAI);
        
        ArrayList<String> BSWTOTAL = new ArrayList<>();
        BSWTOTAL.add("BSWTOTALOilIndicator");
        BSWTOTAL.add("OilTreatmentArea");
        hm.put("BSW_SAI", BSWTOTAL);
        
        ArrayList<String> CONSGAS = new ArrayList<>();
        CONSGAS.add("CONSGASGasIndicator");
        CONSGAS.add("GasTreatmentArea");
        hm.put("CONS_GAS", CONSGAS);
        
        ArrayList<String> CONSLP = new ArrayList<>();
        CONSLP.add("CONSLPGasIndicator");
        CONSLP.add("GasTreatmentArea");
        hm.put("CONS_LP", CONSLP);
        
        ArrayList<String> CONSTC = new ArrayList<>();
        CONSTC.add("CONSTCGasIndicator");
        CONSTC.add("GasTreatmentArea");
        hm.put("CONS_TC", CONSTC);
        
        ArrayList<String> CONSTG = new ArrayList<>();
        CONSTG.add("CONSTGGasIndicator");
        CONSTG.add("GasTreatmentArea");
        hm.put("CONS_TG", CONSTG);
        
        ArrayList<String> CONSUMO = new ArrayList<>();
        CONSUMO.add("CONSUMOGasIndicator");
        CONSUMO.add("GasTreatmentArea");
        hm.put("CONSUMO", CONSUMO);
        
        ArrayList<String> EFC = new ArrayList<>();
        EFC.add("EFCOilIndicator");
        EFC.add("OilTreatmentArea");
        hm.put("EFC", EFC);
        
        ArrayList<String> EFIC = new ArrayList<>();
        EFIC.add("EFICOilIndicator");
        EFIC.add("OilTreatmentArea");
        hm.put("EFIC", EFIC);
        
        ArrayList<String> EFICOPER = new ArrayList<>();
        EFICOPER.add("EFICOPEROilIndicator");
        EFICOPER.add("OilTreatmentArea");
        hm.put("EFIC_OPER", EFICOPER);
        
        ArrayList<String> EGAS = new ArrayList<>();
        EGAS.add("EGASGasIndicator");
        EGAS.add("GasTreatmentArea");
        hm.put("EGAS", EGAS);
        
        ArrayList<String> EXPGAS = new ArrayList<>();
        EXPGAS.add("EXPGASGasIndicator");
        EXPGAS.add("GasTreatmentArea");
        hm.put("EXP_GAS", EXPGAS);
        
        ArrayList<String> FGAS = new ArrayList<>();
        FGAS.add("FGASGasIndicator");
        FGAS.add("GasTreatmentArea");
        hm.put("FGAS", FGAS);
        
        ArrayList<String> GASLIFT = new ArrayList<>();
        GASLIFT.add("GASLIFTGasIndicator");
        GASLIFT.add("GasTreatmentArea");
        hm.put("GAS_LIFT", GASLIFT); 
        
        ArrayList<String> GL = new ArrayList<>();
        GL.add("GLGasIndicator");
        GL.add("GasTreatmentArea");
        hm.put("GL", GL); 
        
        ArrayList<String> GNA = new ArrayList<>();
        GNA.add("GNAGasIndicator");
        GNA.add("GasTreatmentArea");
        hm.put("GNA", GNA); 
        
        ArrayList<String> GSCOMBUST = new ArrayList<>();
        GSCOMBUST.add("GSCOMBUSTGasIndicator");
        GSCOMBUST.add("GasTreatmentArea");
        hm.put("GS_COMBUST", GSCOMBUST); 
        
        ArrayList<String> IMPGAS = new ArrayList<>();
        IMPGAS.add("IMPGASGasIndicator");
        IMPGAS.add("GasTreatmentArea");
        hm.put("IMP_GAS", IMPGAS); 
        
        ArrayList<String> IMPGSAP = new ArrayList<>();
        IMPGSAP.add("IMPGSAPGasIndicator");
        IMPGSAP.add("GasTreatmentArea");
        hm.put("IMP_GS_AP", IMPGSAP); 
        
        ArrayList<String> IMPGSBP = new ArrayList<>();
        IMPGSBP.add("IMPGSBPGasIndicator");
        IMPGSBP.add("GasTreatmentArea");
        hm.put("IMP_GS_BP", IMPGSBP); 
        
        ArrayList<String> IMPGSPA = new ArrayList<>();
        IMPGSPA.add("IMPGSPAGasIndicator");
        IMPGSPA.add("GasTreatmentArea");
        hm.put("IMP_GS_PA", IMPGSPA); 
        
        ArrayList<String> INJEO = new ArrayList<>();
        INJEO.add("INJEOGasIndicator");
        INJEO.add("GasTreatmentArea");
        hm.put("INJEO", INJEO); 
        
        ArrayList<String> IUGAP = new ArrayList<>();
        IUGAP.add("IUGAPGasIndicator");
        IUGAP.add("GasTreatmentArea");
        hm.put("IUGAP", IUGAP); 
        
        ArrayList<String> MCA = new ArrayList<>();
        MCA.add("MCAGasIndicator");
        MCA.add("GasTreatmentArea");
        hm.put("MC_A", MCA); 
        
        ArrayList<String> MCB = new ArrayList<>();
        MCB.add("MCBGasIndicator");
        MCB.add("GasTreatmentArea");
        hm.put("MC_B", MCB); 
        
        ArrayList<String> MCC = new ArrayList<>();
        MCC.add("MCCGasIndicator");
        MCC.add("GasTreatmentArea");
        hm.put("MC_C", MCC); 
        
        ArrayList<String> MC = new ArrayList<>();
        MC.add("MCGasIndicator");
        MC.add("GasTreatmentArea");
        hm.put("MC", MC); 
        
        ArrayList<String> METADES = new ArrayList<>();
        METADES.add("METADESOilIndicator");
        METADES.add("OilTreatmentArea");
        hm.put("META_DES", METADES); 
        
        ArrayList<String> META = new ArrayList<>();
        META.add("METAOilIndicator");
        META.add("OilTreatmentArea");
        hm.put("META", META); 
        
        ArrayList<String> PERDA = new ArrayList<>();
        PERDA.add("PERDAOilIndicator");
        PERDA.add("OilTreatmentArea");
        hm.put("PERDA", PERDA); 
        
        ArrayList<String> PEXP = new ArrayList<>();
        PEXP.add("PEXPGasIndicator");
        PEXP.add("GasTreatmentArea");
        hm.put("P_EXP", PEXP); 
        
        ArrayList<String> PGAS = new ArrayList<>();
        PGAS.add("PGASGasIndicator");
        PGAS.add("GasTreatmentArea"); 
        hm.put("PGAS", PGAS); 
        
        ArrayList<String> P = new ArrayList<>();
        P.add("PGasIndicator");
        P.add("GasTreatmentArea");
        hm.put("P", P); 
        
        ArrayList<String> PGSLIFT = new ArrayList<>();
        PGSLIFT.add("PGSLIFTGasIndicator");
        PGSLIFT.add("GasTreatmentArea"); 
        hm.put("PGS_LIFT", PGSLIFT); 
        
        ArrayList<String> PLO = new ArrayList<>();
        PLO.add("PLOOilIndicator");
        PLO.add("OilTreatmentArea");
        hm.put("PLO", PLO); 
        
        ArrayList<String> PO = new ArrayList<>();
        PO.add("POOilIndicator");
        PO.add("OilTreatmentArea"); 
        hm.put("PO", PO); 
        
        ArrayList<String> POTGS = new ArrayList<>();
        POTGS.add("POTGSGasIndicator");
        POTGS.add("GasTreatmentArea");
        hm.put("POT_GS", POTGS); 
        
        ArrayList<String> POT = new ArrayList<>();
        POT.add("POTOilIndicator");
        POT.add("OilTreatmentArea");
        hm.put("POT", POT); 
        
        ArrayList<String> POTPREV = new ArrayList<>();
        POTPREV.add("POTPREVOilIndicator");
        POTPREV.add("OilTreatmentArea");
        hm.put("POT_PREV", POTPREV); 
        
        ArrayList<String> PRGAS = new ArrayList<>();
        PRGAS.add("PRGASGasIndicator");
        PRGAS.add("GasTreatmentArea");
        hm.put("PR_GAS", PRGAS); 
        
        ArrayList<String> PRODGAS = new ArrayList<>();
        PRODGAS.add("PRODGASGasIndicator");
        PRODGAS.add("GasTreatmentArea");
        hm.put("PROD_GAS", PRODGAS); 
        
        ArrayList<String> QBEXP = new ArrayList<>();
        QBEXP.add("QBEXPOilIndicator");
        QBEXP.add("OilTreatmentArea");
        hm.put("QB_EXP", QBEXP); 
        
        ArrayList<String> QB = new ArrayList<>();
        QB.add("QBOilIndicator");
        QB.add("OilTreatmentArea");
        hm.put("QB", QB); 
        
        ArrayList<String> QBPROD = new ArrayList<>();
        QBPROD.add("QBPRODOilIndicator");
        QBPROD.add("OilTreatmentArea");
        hm.put("QB_PROD", QBPROD); 
        
        ArrayList<String> QBRUTA = new ArrayList<>();
        QBRUTA.add("QBRUTAOilIndicator");
        QBRUTA.add("OilTreatmentArea"); 
        hm.put("Q_BRUTA", QBRUTA); 
        
        ArrayList<String> QOLEO = new ArrayList<>();
        QOLEO.add("QOLEOOilIndicator");
        QOLEO.add("OilTreatmentArea");
        hm.put("Q_OLEO", QOLEO); 
        
        ArrayList<String> QUEIMA = new ArrayList<>();
        QUEIMA.add("QUEIMAGasIndicator");
        QUEIMA.add("GasTreatmentArea"); 
        hm.put("QUEIMA", QUEIMA); 
        
        ArrayList<String> RECEBIMENTO = new ArrayList<>();
        RECEBIMENTO.add("RECEBIMENTOGasIndicator");
        RECEBIMENTO.add("GasTreatmentArea");  
        hm.put("RECEBIMENTO", RECEBIMENTO); 
        
        ArrayList<String> SALIN = new ArrayList<>();
        SALIN.add("SALINOilIndicator");
        SALIN.add("OilTreatmentArea"); 
        hm.put("SALIN", SALIN); 
        
        ArrayList<String> TCA = new ArrayList<>();
        TCA.add("TCAGasIndicator");
        TCA.add("GasTreatmentArea");
        hm.put("TC_A", TCA); 
        
        ArrayList<String> TCB = new ArrayList<>();
        TCB.add("TCBGasIndicator");
        TCB.add("GasTreatmentArea"); 
        hm.put("TC_B", TCB); 
        
        ArrayList<String> TCC = new ArrayList<>();
        TCC.add("TCCGasIndicator");
        TCC.add("GasTreatmentArea"); 
        hm.put("TC_C", TCC); 
        
        ArrayList<String> TH2S = new ArrayList<>();
        TH2S.add("TH2SOilIndicator");
        TH2S.add("OilTreatmentArea");  
        hm.put("TC_C", TH2S); 
        
        ArrayList<String> TO = new ArrayList<>();
        TO.add("TOOilIndicator");
        TO.add("OilTreatmentArea"); 
        hm.put("TO", TO); 
        
        ArrayList<String> VAZAOOLEO = new ArrayList<>();
        VAZAOOLEO.add("VAZAOOLEOOilIndicator");
        VAZAOOLEO.add("OilTreatmentArea"); 
        hm.put("VAZAO_OLEO", VAZAOOLEO); 
        
        return hm;
    }
    
}
