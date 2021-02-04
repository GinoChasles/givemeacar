import {
    AutocompleteInput, DateTimeInput, Edit, ReferenceInput, SimpleForm, useTranslate
} from "react-admin";
import * as React from "react";

const EditRent = (props) => {

    const t = useTranslate();

    return <Edit {...props} undoable={false} title={t('custom.edition')}>
        <SimpleForm>

            <DateTimeInput label={t('custom.Start')} source="start" />

            <DateTimeInput label={t('custom.End')} source="end" />

            <ReferenceInput label={t('custom.car')} source="car_id" reference="cars">
                <AutocompleteInput optionText="name" optionValue={"id"} />
            </ReferenceInput>

            <ReferenceInput label={t('custom.client')} source="client_id" reference="clients">
                <AutocompleteInput optionText="name" optionValue={"id"} />
            </ReferenceInput>
        </SimpleForm>
    </Edit>
}

export default EditRent