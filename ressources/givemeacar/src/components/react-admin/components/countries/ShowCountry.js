import * as React from "react";

import { useTranslate } from "react-admin";

import {
    Show,
    SimpleShowLayout,
    TextField,

} from "react-admin";


const ShowCountry = (props) => {

    const t = useTranslate();

    return <Show {...props}>
        <SimpleShowLayout>
            <TextField label={t('custom.id')} source="id" />

            <TextField label={t('custom.name')} source="name" />
        </SimpleShowLayout>
    </Show>
}

export default ShowCountry;
