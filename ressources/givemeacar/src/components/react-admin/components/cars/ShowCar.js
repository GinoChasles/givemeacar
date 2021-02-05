import * as React from "react";

import { useTranslate } from "react-admin";

import {
    Show,
    SimpleShowLayout,
    TextField,
    BooleanField,
    ReferenceField
} from "react-admin";


const ShowCar = (props) => {

    const t = useTranslate();

    return <Show {...props} title={t('word.description')}>
        <SimpleShowLayout>
            <TextField label={t('word.kilometers')} source="kilometers" />

            <TextField label={t('word.price')} source="price" />

            <TextField label={t('word.year')} source="year" />

            <BooleanField label={t('word.available')} source="available" />

            <BooleanField label={t('word.rented')} source="rented" />
            
            <ReferenceField link="show" label={t('word.brand')} source="brandId" reference="brands">
                <TextField source="name" />
            </ReferenceField>

            <ReferenceField link="show" label={t('word.model')} source="model_id" reference="models">
                <TextField source="name" />
            </ReferenceField>

            <ReferenceField link="show" label={t('word.color')} source="color_id" reference="colors">
                <TextField source="name" />
            </ReferenceField>

            <TextField label={t('word.energyCurrent')} source="energyCurrent" />

            <TextField label={t('word.energyMax')} source="energyMax" />

            <ReferenceField link="show" label={t('word.energy')} source="energy_type_id" reference="energy_types">
                <TextField source="name" />
            </ReferenceField>

            <TextField label={t('word.latitude')} source="latitude" />

            <TextField label={t('word.longitude')} source="longitude" />

        </SimpleShowLayout>
    </Show>
}

export default ShowCar;
