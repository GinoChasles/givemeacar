import React from 'react'


import { useTranslate } from "react-admin";

import {
    ReferenceInput,
    AutocompleteInput,
    required,
} from "react-admin";

export default function Color() {

    const t = useTranslate();

    return <ReferenceInput label={t('word.color')} source="color_id"
        reference="colors" validate={[
            required(t('error.required'))
        ]}>
        <AutocompleteInput optionText="name" optionValue={"id"} />
    </ReferenceInput>
}
