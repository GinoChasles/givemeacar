package fr.givemeacar.app.model;

/**
 * Interface pour les modèles disposant d'une adresse (agence,user...)
 */
public interface HasAddress {

    City getCity();

    Street getStreet();

    StreetSuffix getStreetSuffix();

    /**
     * Retourne le nom du suffixe de la rue où se situe le modèle
     *
     * @return le nom du suffixe de la rue où se situe le modèle
     */
    default String getStreetSuffixName(){
        if(getStreetSuffix() != null){
            return getStreetSuffix().getName();
        }
        return null;
    }

    /**
     * Retourne le nom de la ville où se situe le modèle
     *
     * @return le nom de la ville où se situe le modèle
     */
    default String getCityName(){
        if(getCity() != null){
            return getCity().getName();
        }
        return null;
    }

    /**
     * Retourne le nomde la rue où se situe le modèle
     *
     * @return le nomde la rue où se situe le modèle
     */
    default String getStreetName(){
        if(getStreetNumber() != null){
            return getStreet().getName();
        }
        return null;
    }

    /**
     * Retourne le zipcode de la ville où se situe le modèle
     *
     * @return le zipcode de la ville où se situe le modèle
     */
    default String getZipCode(){
        if(getCity() != null){
            return getCity().getZipcode();
        }
        return null;
    }

    /**
     * @return le numéro de rue où se situe le modèle
     */
    String getStreetNumber();

    /**
     * Retourne l'adresse complète du modèle
     * @return l'adresse complète du modèle
     */
    public default String getAddress(){
        return getStreetNumber() + " "
                + getStreetSuffixName() + " "
                + getStreetName() + " - "
                + getZipCode() + " "
                + getCityName();
    }
}
