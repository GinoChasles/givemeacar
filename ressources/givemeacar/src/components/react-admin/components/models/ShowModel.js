import * as React from "react";

import { useTranslate, ReferenceInput, AutocompleteInput } from "react-admin";

import {
    Show,
    SimpleShowLayout,
    TextField,
    EmailField,
    ReferenceField,

} from "react-admin";


const ShowModel = (props) => {

    const t = useTranslate();

    return <Show {...props}>
        <SimpleShowLayout>

            <TextField label={t('custom.id')} source="id" />

            <TextField label={t('custom.name')} source="name" />

            <ReferenceInput label={t('custom.brand')} source="brand_id" reference="brands">
                <AutocompleteInput source="name" />
            </ReferenceInput>

        </SimpleShowLayout>
    </Show>
}

export default ShowModel;
