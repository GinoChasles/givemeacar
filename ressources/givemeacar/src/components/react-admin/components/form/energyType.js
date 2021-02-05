import React from 'react'


import { useTranslate } from "react-admin";

import {
    ReferenceInput,
    AutocompleteInput,
    required,
} from "react-admin";

export default function EnergyType() {

    const t = useTranslate();

    return <ReferenceInput label={t('word.energyType')} source="energy_type_id" reference="energy_types" validate={[
        required(t('error.required'))
    ]}>
        <AutocompleteInput optionText="name" optionValue={"id"} />
    </ReferenceInput>
}
