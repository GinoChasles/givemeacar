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

    return <Show {...props}>
        <SimpleShowLayout>
            <TextField label={t('custom.kilometers')} source="kilometers" />

            <TextField label={t('custom.price')} source="price" />

            <TextField label={t('custom.year')} source="year" />

            <TextField label={t('custom.available')} source="availability" />

            <TextField label={t('custom.rented')} source="inRent" />
            
            <ReferenceField link="show" label={t('custom.brand')} source="brandId" reference="brands">
                <TextField source="name" />
            </ReferenceField>

            <ReferenceField link="show" label={t('custom.model')} source="model_id" reference="models">
                <TextField source="name" />
            </ReferenceField>

            <ReferenceField link="show" label={t('custom.color')} source="color_id" reference="colors">
                <TextField source="name" />
            </ReferenceField>

            <TextField label={t('custom.energyLevel')} source="energyLevel" />

            <ReferenceField link="show" label={t('custom.energy')} source="energy_type_id" reference="energy_types">
                <TextField source="name" />
            </ReferenceField>

            <TextField label={t('custom.latitude')} source="latitude" />

            <TextField label={t('custom.longitude')} source="longitude" />

        </SimpleShowLayout>
    </Show>
}

export default ShowCar;
