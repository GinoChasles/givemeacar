import * as React from "react";

import Model from '../form/model';
import Color from '../form/color';
import Kilometer from '../form/kilometers';
import Price from '../form/price';
import Year from '../form/year';
import Available from '../form/available';
import Rented from '../form/rented';
import EnergyType from '../form/energyType';
import EnergyMax from '../form/energyCurrent';
import EnergyCurrent from '../form/energyMax';
import Longitude from '../form/longitude';
import Latitude from '../form/latitude';

import styles from '../../styles/forms.module.css';

/**
 * Le formulaire de création et d'édition de la voiture
 */
export default function CarForm() {
    return <section className={styles.form}>
        {/** le modèle de la voiture  */}
        <Model />
        {/** l'année de construction de la voiture  */}
        <Year />
        {/** la couleur de la voiture  */}
        <Color />
        {/** le type de carburant de la voiture  */}
        <EnergyType />
        {/** le niveau de carburant actuel de la voiture  */}
        <EnergyCurrent />
        {/** le niveau de carburant max de la voiture  */}
        <EnergyMax />
        {/** le kilométrage de la voiture  */}
        <Kilometer />
        {/** le prix à la minute de la voiture  */}
        <Price />
        {/** la latitude de la voiture  */}
        <Latitude />
        {/** la longitude de la voiture  */}
        <Longitude />
        {/** la disponibilité de la voiture  */}
        <Available />
        {/** l'état de la location en cours de la voiture  */}
        <Rented />
    </section>
}
