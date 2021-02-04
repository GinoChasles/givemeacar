import * as React from "react";

import { useTranslate } from "react-admin";

import {
    Show,
    SimpleShowLayout,
    TextField,
    BooleanField

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

            <TextField label={t('custom.model')} source="modelName" />

            <TextField label={t('custom.color')} source="colorName" />

            <TextField label={t('custom.energyLevel')} source="energyLevel" />

            <TextField label={t('custom.energyType')} source="energy" />

            <TextField label={t('custom.latitude')} source="latitude" />

            <TextField label={t('custom.longitude')} source="longitude" />

        </SimpleShowLayout>
    </Show>
}

export default ShowCar;
