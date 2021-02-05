import * as React from "react";

import { useTranslate } from "react-admin";

import {
    Show,
    SimpleShowLayout,
    TextField,

} from "react-admin";


const ShowSuffix = (props) => {

    const t = useTranslate();

    return <Show {...props} title={t('word.description')}>
        <SimpleShowLayout>
            <TextField label={t('word.id')} source="id" />

            <TextField label={t('word.name')} source="name" />
        </SimpleShowLayout>
    </Show>
}

export default ShowSuffix;
