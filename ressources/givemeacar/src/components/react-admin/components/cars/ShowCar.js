import * as React from "react";

import { useTranslate } from "react-admin";

import {
    Show,
    SimpleShowLayout,
    TextField,
    BooleanField,
    ReferenceField
} from "react-admin";

import styles from './styles.module.css';

/**
 * Carte de présentation de la voiture
 * @param {*} props
 */
const ShowCar = (props) => {

    const t = useTranslate();

    return <Show {...props} title={t('word.description')}>
        <SimpleShowLayout className={styles['show-car']}>
            {/** la marque de la voiture  */}
            <ReferenceField link="show" label={t('word.brand')} source="brandId" reference="brands">
                <TextField source="name" />
            </ReferenceField>
            {/** le modèle de la voiture  */}
            <ReferenceField link="show" label={t('word.model')} source="model_id" reference="models">
                <TextField source="name" />
            </ReferenceField>
            {/** la couleur de la voiture  */}
            <ReferenceField link="show" label={t('word.color')} source="color_id" reference="colors">
                <TextField source="name" />
            </ReferenceField>
            {/** le type de carburant de la voiture  */}
            <ReferenceField link="show" label={t('word.energy')} source="energy_type_id" reference="energy_types">
                <TextField source="name" />
            </ReferenceField>
            {/** le niveau de carburant actuel de la voiture  */}
            <TextField label={t('word.energyCurrent')} source="energyCurrent" />
            {/** le niveau de carburant max de la voiture  */}
            <TextField label={t('word.energyMax')} source="energyMax" />
            {/** l'année de construction de la voiture  */}
            <TextField label={t('word.year')} source="year" />
            {/** la latitude de la voiture  */}
            <TextField label={t('word.latitude')} source="latitude" />
            {/** longitude de la voiture  */}
            <TextField label={t('word.longitude')} source="longitude" />
            {/** le kilométrage de la voiture  */}
            <TextField label={t('word.kilometers')} source="kilometers" />
            {/** la disponibilité de la voiture  */}
            <BooleanField label={t('word.available')} source="available" />
            {/** l'état de la location en cours de la voiture  */}
            <BooleanField label={t('word.rented')} source="rented" />
            {/** le prix à la minute de la voiture  */}
            <TextField label={t('word.pricePerMin')} source="price" />
        </SimpleShowLayout>
    </Show>
}

export default ShowCar;
