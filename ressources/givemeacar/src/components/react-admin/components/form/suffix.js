import React from 'react'


import { useTranslate } from "react-admin";

import {
    ReferenceInput,
    AutocompleteInput,
} from "react-admin";

export default function Suffix() {

    const t = useTranslate();

    return <ReferenceInput label={t('word.suffix')} source="street_suffix_id" reference="street_suffices">
        <AutocompleteInput optionText="name" optionValue={"id"} />
    </ReferenceInput>
}
