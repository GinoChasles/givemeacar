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

    return <Show {...props} title={t('word.description')}>
        <SimpleShowLayout>
            <TextField label={t('word.id')} source="id" />

            <DateField label={t('word.rentStart')} source="start" showTime />

            <DateField label={t('word.rentEnd')} source="end" showTime />

            <TextField label={t('word.car')} source="car_id" />

            <TextField label={t('word.client')} source="client_id" />

        </SimpleShowLayout>
    </Show>
}

export default ShowModel;
