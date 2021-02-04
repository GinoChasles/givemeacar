import * as React from "react";

import { useTranslate } from "react-admin";

import {
    Show,
    SimpleShowLayout,
    TextField,
    ReferenceField
} from "react-admin";


const ShowCar = (props) => {

    const t = useTranslate();

    return <Show {...props} title={t('word.description')}>
        <SimpleShowLayout>
            <TextField label={t('word.kilometers')} source="kilometers" />

            <TextField label={t('word.price')} source="price" />

            <TextField label={t('word.year')} source="year" />

            <TextField label={t('word.available')} source="availability" />

            <TextField label={t('word.rented')} source="inRent" />
            
            <ReferenceField link="show" label={t('word.brand')} source="brandId" reference="brands">
                <TextField source="name" />
            </ReferenceField>

            <ReferenceField link="show" label={t('word.model')} source="model_id" reference="models">
                <TextField source="name" />
            </ReferenceField>

            <ReferenceField link="show" label={t('word.color')} source="color_id" reference="colors">
                <TextField source="name" />
            </ReferenceField>

            <TextField label={t('word.energyLevel')} source="energyLevel" />

            <ReferenceField link="show" label={t('word.energy')} source="energy_type_id" reference="energy_types">
                <TextField source="name" />
            </ReferenceField>

            <TextField label={t('word.latitude')} source="latitude" />

            <TextField label={t('word.longitude')} source="longitude" />

        </SimpleShowLayout>
    </Show>
}

export default ShowCar;
