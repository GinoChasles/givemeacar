import * as React from "react";

import { useTranslate } from "react-admin";

import {
    Show,
    SimpleShowLayout,
    TextField,
    DateField

} from "react-admin";


const ShowModel = (props) => {

    const t = useTranslate();

    return <Show {...props}>
        <SimpleShowLayout>
            <TextField label={t('custom.id')} source="id" />

            <DateField label={t('custom.rentStart')} source="start" showTime />

            <DateField label={t('custom.rentEnd')} source="end" showTime />

            <TextField label={t('custom.car')} source="car_id" />

            <TextField label={t('custom.client')} source="client_id" />

        </SimpleShowLayout>
    </Show>
}

export default ShowModel;
